import socket
from concurrent.futures import *



class Server():
	def __init__(self,host,port):
		self.connection = True
		tcp = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
		origin = (host,port)
		tcp.bind(origin)
		tcp.listen(2)
		self.listen(tcp)

	def read(self,con,cliente,tcp):
		while True:
			msg = con.recv(1024)
			msg = msg.decode()
			if msg == "exit" :
				self.connection = False 
				tpc.shutdown()
				tcp.close()
			print(cliente,":",msg)
		con.close()

	def listen(self,tcp):
		print("Server Escutando")
		pool = ThreadPoolExecutor(max_workers=5)
		while self.connection:
			con, cliente = pool.submit(tcp.accept())
			pool.submit(self.read,con,cliente,tcp)
		tcp.close()
		print("Servidor Desligado")



if __name__=="__main__":
	sever = Server('',5011)

