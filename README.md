# SDHW3

Problem Statement:


In this assignment, we want to extend the first assignment in two ways:

In addition to searching a sorted list of integer, it should be able to search a sorted list of strings. Strings are lexicographically sorted. We want to use the binSearch with minimal modification.  
A solution may change the signature of function binSearch from  binSearch(int[] aList, int key) to  binSearch(Comparable[] aList, Comparable key)  where Comparable is an interface in JDK https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html
 It must provide the following command-line arguments using Apache Commons CLI library https://commons.apache.org/proper/commons-cli/
“--type”, to allow a user to specify types of input: “i” for integer and “s” for string 
 “--key” specifies the value of the search key
“--list”  specifies the sorted list of integers or strings. 
Examples: 
$ java Main --type i --key 6 --list 3 4 5 6
 Denotes that the list is of type integer, the search key is 6, and the list is 3 4 5 6 

$ java Main --type s --key ab --list a aa b  cc
Denotes that the list is type string, the key is “ab” and the list to perform search on is: a aa b cc

Packaging Requirements:
Use maven to specify the dependencies. In other words, do not check in jar files in the library.
“mvn compile” should compile your code without an error or warning.   
