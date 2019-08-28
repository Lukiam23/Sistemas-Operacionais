import socket
import threading

threads = []

class Server():
	def __init__(self,host,port):
		self.connection = True
		tcp = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
		origin = (host,port)
		tcp.bind(origin)
		tcp.listen(2)
		self.listener = threading.Thread(target = self.listen,args = (tcp,))
		self.listener.start()

	def read(self,con,cliente,tcp):
		while True:
			msg = con.recv(1024)
			msg = msg.decode()
			if msg == "exit" :
				self.connection = False
				tcp.close()
			print(cliente,":",msg)
		con.close()
		

	def listen(self,tcp):
		print("Server Escutando")
		while self.connection:
			con, cliente = tcp.accept()
			creator = threading.Thread(target = self.read,args = (con,cliente,tcp,))
			threads.append(creator)
			creator.start()
		tcp.close()
		print("Servidor Desligado")



if __name__=="__main__":
	sever = Server('',5003)

