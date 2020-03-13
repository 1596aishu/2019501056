import socket
host = '127.0.0.1'
port = 65432
with socket.socket(socket.AF_INET, socket.SOCK_DGRAM) as s:
	s.sendall(b'Hello aishu', (host,port))
	data = s.recvrom(1024)
print('recieved', repr(data))