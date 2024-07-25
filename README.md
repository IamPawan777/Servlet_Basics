
# Servlet

⚡️ Servlet is an API / Interfae to build "Dynamic Web Application" using java programming.

⚡️ Package:-  jakarta.servlet.* ;

⚡️Life cycle methods:- 1.init() - 2.service() - 3.destroy()



## Three way to create servlet program:



```bash
  1. via implementing "servlet" interface
  2. via extending "generic servlet" class
  3. via extending "http servlet" class
```
    
### web.xml

Deployment discriptor file.
```bash
  -> Important for mapping servlet file.
  -> All deploment based discription are written here.
  -> This file connect frontend and backend of application.
```



## Basic code:

Implementing servlet interface.

```bash
package servletClass;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/firstServletClass")
public class FirstServletClass implements Servlet {

	public void init(ServletConfig config) throws ServletException {
		System.out.println("int class");
	}

	public void destroy() {
		System.out.println("destroy class");
	}

	public ServletConfig getServletConfig() {
		return null;
	}

	public String getServletInfo() {
		return null; 
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("Service class");
	}
}

```


## Communication:

#### Single application internal page/servars.


| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `servlet to servlet` | `Internal` |  RequestDispature rd = request.getRequestDispature();

#### Different application one servar to other servar.

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `servlet to other servlet`      | `External` | response.sendRedirect(""); |



## Communication Ways:

 - URL-Parameter
 - Request Attributes
 - Http Session Attributes
 - Adding Cookies


## Print in browser:

PrintWriter pw  = response.getWriter();

pw.println(".......");

## 🚀 Prerequisities
👩‍💻 Java (OOPs)

💬 JDBC(java Database Connectivity)

📫 Servlet

👯‍♀️ MySQL Database

🧠 Eclipse IDE


🤔 Java SQL Connector(jar file)


## Screenshots

### On Eclipse: 


![Screenshot (3)](https://github.com/user-attachments/assets/0b251eee-87aa-4843-8630-c96205ba76d0)




### On Browser: 

![Screenshot (1)](https://github.com/user-attachments/assets/2f46910c-89a6-4146-a9a2-a3a851d51303)
)

### On Server:

![Screenshot (1)](https://github.com/user-attachments/assets/7e0443bc-6bb9-42a9-9540-d1c8c83ca266)
## Tech Stack:

**Client:** HTML, CSS

**Server:** Servlet
 
 **Other:** MySQL, JDBC


## 🔗 Links

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/pawan-bisht-a0578b201/)



# Thank You...! 👋

