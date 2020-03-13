import socket
host = '127.0.0.1'
port = 65432
with socket.socket(socket.AF_INET, socket.SOCK_DGRAM) as s:
	s.connect((host,port))
	s.sendall(b'hello aishu')
	data = s.recv(1024)
print('recieved', repr(data))