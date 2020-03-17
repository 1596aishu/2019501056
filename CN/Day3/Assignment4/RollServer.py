
import socket, threading, os
from _thread import *
from threading import *

def clientthread(conn, addr):
	while True:
		message = conn.recv(2048)
		for client in client_list:
			if client != conn:
				client.send(message)
	conn.close()

roll_list = [2019501065, 2019501111, 2019501013, 2019501056, 2019501107]
string  = str(roll_list[0])
print('Students in the class:')
for i in range(1, len(roll_list)):
	string = string + ' - ' +str(roll_list[i])
print(string)

soc = socket.socket()
soc.bind(('localhost', 8180))
soc.listen(10)
client_list = []
while True:
	conn, addr = soc.accept()
	client_list.append(conn)
	print(str(addr) + ' connected')
	rollnum = conn.recv(1024).decode()
	checkroll = int(rollnum)
	if checkroll in roll_list:
		conn.send('\nPresent'.encode())
	else:
		conn.send('\nError'.encode())
	#Thread(target = clientthread,args = (conn,addr)).start()
conn.close()
soc.close()