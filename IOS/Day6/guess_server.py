# -*- coding: utf-8 -*-

import socket
import sys
import random

sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
host = '127.0.0.1'
port = 10002
sock.bind((host,port))
sock.listen()
num = random.triangular(1,50)
conn,addr = sock.accept()
print('connected by' , addr)
conn.recv(1024).decode()
conn.sendall(b'READY')
while True:
    data = int(conn.recv(1024).decode())
    if(data>num): 
        conn.sendall(b'HIGH')
    elif(data<num): 
        conn.sendall(b'LOW')
    elif(data == num):        
        conn.sendall(b'Correct! ')
        break
