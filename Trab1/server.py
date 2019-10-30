import socket
import threading

class Server():
	def __init__(self,host,port):
		self.cons = []
		self.event = threading.Event()
		self.connection = True
		self.tcp = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
		origin = (host,port)
		self.tcp.bind(origin)
		self.tcp.listen(2)
		

	def read(self,con,cliente):
		msg = ''
		while self.connection:
			msg = con.recv(1024).decode()
			if msg == "exit":
				self.connection = False
				self.event.set()
			print(cliente,":",msg)
		for i in self.cons:
			i.close()
		
		
	def conWatcher(self):
		while self.connection:
			try:
				con, cliente = self.tcp.accept()
				self.cons.append(con)
				creator = threading.Thread(target = self.read,args = (con,cliente,))
				creator.start()
			except:
				pass

	def run(self):
		print("Server Escutando")
		self.accept = threading.Thread(target = self.conWatcher)
		self.accept.start()
		if self.event.wait():
			#self.tcp.shutdown(2)
			self.tcp.close()
			
		print("Servidor Desligado")



if __name__=="__main__":
	server = Server('',5000)
	server.run()
	
