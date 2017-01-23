# Description

Takes a file with a newline delimited list of email addresses, sorts them, and prints the sorted output.
Email addresses are sorted by domain name, ignoring TLD, and also subdomains. 

Addresses are assumed to have one '@' symbol and at least one '.' symbol in the domain name. 
Addresses are not validated and error checking input is minimal. 

# Instructions

Use maven to build the application:

```
mvn clean install
```

Example run of the application. 

```
cd target
java -jar sort-emails.jar classes\samples\sample.txt
abc@abc.com
rwq@abc.org
dave@gibson.com
joe@npr.org
cde@yahoo.com
```
