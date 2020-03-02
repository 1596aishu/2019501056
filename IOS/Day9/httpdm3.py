import socket
import os
class HTTPServer:
    def __init__(self, IP, port):
        super().__init__()
        with socket.socket(socket.AF_INET, socket.SOCK_STREAM, socket.IPPROTO_TCP) as self.s:
            self.s.bind((IP, port))
            self.s.listen()
            while True:
                conn, addr = self.s.accept()
                with conn:
                    print('Connected by', addr)
                    # TODO read the request and extract the URI
                    d = conn.recv(1024).decode()
                    d1 = d.split('\n')
                    d2 = d1[0].split(' ')
                    # TODO update the parameter with the request URI
                    uri = d2[1]
                    code, c_type, c_length, data = self.links(uri)
                    response = self.response_headers(code, c_type, c_length) + data
                    conn.sendall(response)
                    conn.close()
   
    def get_data(self, uri):
        if uri == "/":
            data = "<h1>Webserver Under construction</h1>"
            return 200,"text/html",len(data),data.encode()
        strs = uri.split(".")
        print(strs[1])
        req_type = strs[1]
        if req_type == "html":
            p = os.getcwd()
            URL = p +uri
            print(URL)
            if os.path.exists(URL):
                file = open(URL,'rb')
                line = file.read()
                data = line
                return 200, "text/html", len(data), data
            else:
                data = "<h1>File Not Found</h1>"
                return 404, "text/html", len(data), data.encode()
        elif req_type == "png":
            p = os.getcwd()
            URL = p +uri
            print(URL)
            if os.path.exists(URL):
                file = open(URL,'rb')
                data = file.read()
                file.close()
                return 200, "image/png", len(data), data
            else:
                data = "<h1>File Not Found</h1>"
                return 404, "text/html", len(data), data.encode()
        elif req_type == "gif":
            p = os.getcwd()
            URL = p +uri
            print(URL)
            if os.path.exists(URL):
                file = open(URL,'rb')
                data = file.read()
                file.close()
                return 200, "image/gif", len(data), data
            else:
                data = "<h1>File Not Found</h1>"
                return 404, "text/html", len(data), data.encode()
        else:	
            data = "<h1>File Not Found</h1>"
            return 404, "text/html", len(data), data.encode()

    def links(self, uri):
        if uri == "/":
            uri = "www"
            file = os.listdir(uri)
            str = ""
            for i in file:
                paths = uri+'/'+i
                str += "<a href = "+paths+">"+i+"</a> </br>"
            return 200, "text/html", len(str), str.encode()
        else:
            if "." in uri:
                return self.get_data(uri)
            else:
                file = os.listdir(uri)
                str = ""
                for i in file:
                    paths = uri+'/'+i
                    str += "<a href = "+paths+">"+i+"</a> </br>"
                return 200, "text/html", len(str), str.encode()

    def response_headers(self, status_code, content_type, length):
        line = "\n"
       
        # TODO update this dictionary for 404 status codes
        response_code = {status_code: str(status_code)+" OK"}
       
        headers = ""
        headers += "HTTP/1.1 " + response_code[status_code] + line
        headers += "Content-Type: " + content_type + line
        headers += "Content-Length: " + str(length) + line
        headers += "Connection: close" + line
        headers += line
        return headers.encode()

def main():
    # test harness checks for your web server on the localhost and on port 8888
    # do not change the host and port
    # you can change  the HTTPServer object if you are not following OOP
    HTTPServer('127.0.0.1', 8888)

if __name__ == "__main__":
    main()                   


