import socket

soc = socket.socket()
soc.connect(('localhost', 8180))
while True:
    print('Enter your rollnumber: ', end = " ")
    rollnum = input()
    soc.send(rollnum.encode())
    while True:
        data = soc.recv(1024).decode()
        if not data:
            continue
        print (str(data))
    soc.close()