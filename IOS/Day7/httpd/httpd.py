'''
    Disclaimer
    tiny httpd is a web server program for instructional purposes only
    It is not intended to be used as a production quality web server
    as it does not fully in compliance with the 
    HTTP RFC https://tools.ietf.org/html/rfc2616

    This task is designed by Praveen Garimella and is to be used
    as part of the Learning by Doing, Project Based Course on Operating Systems
    Write to pg@fju.us for any questions or comments
'''

'''
    == Task 1 ==
    In the first task you have to create a initial version of a web server
    to accept connections from HTTP clients and
    sends a HTTP response with a text message
    "Tiny HTTP Server is Under Construction..."

    This programming task recommends the use of OOP python.
    The guide that is given below follows OOP. It is understandable if you choose not to use OOP.
    The test harness that verifies your program would still work for non OOP solutions.
    
    The following are the high level steps that will help you to complete the task
    For more detailed explanation for these steps go to the references section below.
    There are references to tutorials that explain details if you need to learn.

    1. Create a python class to represent a HTTP server
    
    2. Initialize the constructor with IP and port as parameters
        2.1 In the constructor, create a socket and bind it with the given IP and port
        2.2 Servers are supposed to run forever, so start an infinite loop
        2.3 accept client connections
        2.4 For the first version create a HTTP response to the client with the body 
            "<h1>Webserver Under construction</h1>"
            2.4.1 Set the HTTP headers:
                    Content-Type to text/html
                    Content-Length to the length of the content in bytes
                    Connection to close
            2.4.2 Send the HTTP response to the client

    In the main function, instantiate the HTTP Server object.

    Test your program by opening the web browser and pointing the url to
    http://IP:port that are passed to the constructor.
    You should see the text Tiny HTTP Server is Under Construction...
    Use the browsser's developer tools to verify if all the headers set are as specified

    References:
    For a tutorial on python sockets: https://realpython.com/python-sockets/
    To learn about HTTP Responses: https://www.tutorialspoint.com/http/http_responses.htm

    Common errors to look for:
    Constructing the HTTP Response with the correct headers is tricky
'''
import socket
class HTTPServer:
    '''
        Remove the pass statement below and write your code here
    '''
    def __init__(self, host, port):
        sock = socket.socket()
        sock.bind((host,port))
        sock.listen(1024)
        while(True):
            conn, addrs = sock.accept()
            if conn:
                conn.recv(1024)
                data = b'''HTTP/1.0 200 OK
                content-type: text/html
                content-length: 200
                
                <html>
                <head>
                <title> Tiny Web Server </title>
                </head>
                <body>
                <h2> Web server under construction</h2>
                </body>
                </html>
                '''
                conn.sendall(data)
                conn.close()
                print('connection closed')
                sock.close()
    pass

def main():
    # test harness checks for your web server on the localhost and on port 8888
    # do not change the host and port
    # you can change  the HTTPServer object if you are not following OOP
    HTTPServer('127.0.0.1', 8888)

if __name__ == "__main__":
    main()                   