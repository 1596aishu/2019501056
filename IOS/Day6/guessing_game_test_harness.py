# -*- coding: utf-8 -*-
"""guessing_game_test_harness.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1Q29Gxgrvbm0euUn4SPbndrCzF6ObvVwq

# Guessing Game Test Harness
This notebook contains code cells that test the guessing game server and client LxD task given as part of the OS course offered in the MSIT program. Run the code blocks below one after the other to verify if your program meets the task specifications. The feedback printed by the code blocks will describe the error or it says that the task meets the given specification.

The first code cell below checks if the client is able to connect to the server. On success it prints **Connection to the server meets the specification**
"""

import socket
import sys
import random

# TODO: Set the name variable to your roll number.
name = '2019501056'

if name:

  # Create a TCP/IP socket
  sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

  # Connect the socket to the port where the server is listening
  server_address = ('127.0.0.1', 10002)
  print ('connecting to %s port %s' % server_address)
  sock.connect(server_address)
  print ('Connection to the server meets the specification')

else:
  print ("Fail: To run the test cases set the name variable to your rollnumber")

"""The code block below tests the protocol between the client and server.



1.   Client sends a `Hi <name>` message
2.   Server sends a `READY` message
3.   Client and Server loops through some guess and check transactions to determine the secret number
4.   Once the secret number is guessed the server sends a message that begins with `Correct! <name>`
"""

try:
    
    # Send data
    message = 'Hi ' + name
    print ('sending "%s"' % message)
    sock.sendall(message.encode())

    # Look for the READY response
    amount_received = 0
    amount_expected = len("READY")
    
    while amount_received < amount_expected:
        data = sock.recv(1024)
        amount_received += len(data)
        print ('received "%s"' % data)
        
        if data.decode() == "READY":
            lo = 1
            hi = 100
            n = random.randint(lo, hi)
            while True:
                sock.sendall(str(n).encode())
                data = sock.recv(1024)
                if data.decode() == 'HIGH':
                    hi = n
                    n = int((lo + hi)/2)
                    # n = int((lo + n)/2)
                    # hi = n
                elif data.decode() == 'LOW':
                    lo = n
                    n = int((lo + hi)/2)
                elif data.decode().startswith('Correct! '):
                    print ('Server program meets specification. Good job!')
                    break
                else:
                    print ('Fail: Server program did not send the expected message')
                    break
        else:
            print ('Fail: Did not receive the message "READY" from server')
finally:
    print ('closing socket')
    sock.close()