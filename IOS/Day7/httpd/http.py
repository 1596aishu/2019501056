import socket
def main():
	def handle_message(message):
		http_response = b"""\
			HTTP/1.1 200OK
			Content-Type: html;
			
			<html>
			<head>
			<h1> Tiny Web Server </h1>
			</head>
			<body>
			<h2> Wesite under construction</h2>
			</body>
			</html>
			"""
		return http_response
    sock = socket.socket()
    host = '10.10.9.186'
	port = 10002
	sock.bind((host,port))
	sock.listen()
	message,addr = sock.accept()
	print('connected by' , addr)
	data = message.recv(1024)
	message.sendall(handle_message(message))
	message.close()
if __name__ == '__main__':
	main()
