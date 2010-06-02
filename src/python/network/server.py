
import sys
from threading import Thread
from SocketServer import BaseRequestHandler
from SocketServer import ThreadingTCPServer

DEFAULT_BUF_SIZE = 8192


class Handler(BaseRequestHandler):
    def setup(self):
        BaseRequestHandler.setup(self)
        print "connect from:", self.client_address

    def action(self, req):
        print req
        self.request.send("get")

    def handle(self):
        while True:
            req = self.request.recv(DEFAULT_BUF_SIZE)
            if len(req) == 0:
                break
            self.action(req)

    def finish(self):
        self.request.close()


class Server(Thread):
    def __init__(self, host="127.0.0.1", port=3794, handler=Handler):
        Thread.__init__(self)
        self.server = ThreadingTCPServer((host, port), handler)

    def run(self):
        self.server.serve_forever()

    def stopRunning(self):
        self.server.shutdown()
        self.server.server_close()

if __name__ == '__main__':
    server = Server()
    server.start()
    print "input 'exit' to quit"
    while True:
        msg = raw_input()
        if "exit" == msg:
            break
    print "start stopping..."
    server.stopRunning()
    print "stoped."
    sys.exit()
