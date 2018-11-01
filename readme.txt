Two-Phase Multiway Merge-Sort
The task is to sort a large input ﬁle of tuples (records).
 The input ﬁle is given as a text-ﬁle in which each line of the ﬁle is a positive integer (with possibly duplicated values), 
 where each integer is a tuple. The task is to compare the tuples in the list and to output to a ﬁle the same list where its 
 tuples are sorted in ascending order. The ﬁrst line of the input ﬁle will indicate the number of tuples in it and the amount of allowed maximum main memory. 
 The second line of the input ﬁle is blank and from the third line the tuples start. Example
1000000 5mb
111111 234566 22 ... ...
The sorting algorithm is the Two-Phase Multiway Merge-Sort with possibly several
 rounds of merging in Phase 2. and based on the given input information your algorithm 
 should determine the best buﬀer size before it starts the actual sorting.
 
 IMPORTANT NOTE:  Use Xmxkm to restrict the main memory usage to k MB. for example Xmx5m will restrict the main memory to 5MB. You need to set it up on Eclipse. 
 
 *** Run DatabaseProject1ASPS.java
 
 NOTE: Use Eclipse/Net beans
 
 NOTE: Change filePath according to your PC\
 
 Extra File
 
 1) TESTING FOLDER contains data Set
 
 2) DataSetCreation.java is used to create data set of any size
 
 3) CheckSizeToInsertInMainMemory.java is used to check memory consumption in 0.1 million to 1 million dataSet