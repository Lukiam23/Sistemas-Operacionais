import socket

class Client():
	def __init__(self,host,port):
		tcp = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
		dest = (host,port)
		tcp.connect(dest)
		self.run(tcp)
	def run(self,tcp):
		msg = input("Insira a mensagem:")
		while True:
			tcp.send(msg.encode())
			if msg == "exit": break
			msg = input("Insira a mensagem:")
		tcp.close()

if __name__=="__main__":
	client = Client('127.0.0.1',5020)
