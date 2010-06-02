
import sys
from threading import Thread
from server import Handler
from server import Server


class WaitingRoomHandler(Handler):
    def setup(self):
        Handler.setup(self)
        self.request.sendall("Please input username:")
        self.username = ""

    def action(self, req):
        if self.username == "":
            self.username = req
            print "username = " + req
        else:
            print self.username + " : " + req


if __name__ == '__main__':
    host = "127.0.0.1"
    port = 3794
    handler = WaitingRoomHandler
    server = Server(host, port, handler)
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
