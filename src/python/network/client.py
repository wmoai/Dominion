
import sys
import threading
import socket

DEFAULT_IP = "127.0.0.1"
DEFAULT_PORT = 3794
RECV_BUF_SIZE = 1024
error = socket.error


class Socket:
    def __init__(self, host=DEFAULT_IP,  port=DEFAULT_PORT):
        self.threadSet = set()
        self.waiting = True
        self.initSocket(host, port)

    def initSocket(self, host, port):
        sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        self.sock = sock
        sock.connect((host, port))
        waitThread = threading.Thread(target=self.waitForMsg)
        waitThread.start()

    def send(self, msg):
        self.sock.sendall(msg)

    def waitForMsg(self):
        print "start waiting for msg"
        while self.waiting:
            resp = self.sock.recv(RECV_BUF_SIZE)
            if len(resp) == 0:
                break
            print resp
        self.shutdown()

    def shutdown(self):
        self.waiting = False
        try:
            self.sock.shutdown(socket.SHUT_RDWR)
        except socket.error:
            pass

if __name__ == '__main__':
    try:
        s = Socket()
    except socket.error:
        print "Can't init"
        sys.exit()

    while True:
        msg = raw_input()
        if "exit" == msg:
            break
        else:
            try:
                s.send(msg)
            except socket.error:
                break

    s.shutdown()
    print "exited."
