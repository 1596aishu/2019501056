import socket
host = '127.0.0.1'
port = 65432
with socket.socket(socket.AF_INET, socket.SOCK_DGRAM) as s:
	s.bind((host,port))
	while True:
		data = conn.recv(1024)
		if not data:
			break
		print(data[0])
        s.sendto(b"Hello", data[1])
		