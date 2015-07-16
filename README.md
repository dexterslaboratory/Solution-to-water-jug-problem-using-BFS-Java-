# Solution-to-water-jug-problem-using-BFS-Java-
Given two cotainers that can measure nothing but the maximum volume they can be filled with, the program returns sequence of steps that must be followed in order to obtain a specified volume of water (provided such a solution exists,else it returns "No Solution exists")
<br>
Note: For obtaining the optimal solution the volume jug one can hold should be less than the volume that jug<br> 
      two can hold.
<br>
Format:<br>
Input:<br>
Enter volume of jug one<br>
Enter volume of jug two<br>
Enter volume to obtain<br>
<br>
Output:<br>
BFS Tree<br>
Sequence of steps<br>
<br>
Example:<br>
Enter volume of jug one<br>
4<br>
Enter volume of jug two<br>
5<br>
Enter volume to obtain<br>
1<br>
Children of (0,0) are:<br>
(4,0) (0,5)<br>
Children of (4,0) are:<br>
 (4,5) (0,0) (0,4)<br>
Children of (0,5) are:<br>
(4,5) (0,0) (4,1)<br>
Children of (4,5) are:<br>
 (0,5) (4,0)<br>
Children of (0,4) are:<br>
(4,4) (0,5) (0,0)<br>
Children of (4,1) are:<br>
 (4,5) (0,1) (4,0)<br>
Children of (4,4) are:<br>
 (4,5) (0,4) (4,0) (3,5)<br>
Children of (0,1) are:<br>
(4,1) (0,5) (0,0) (1,0)<br>
 Volume obtained <br>
(0,0)<br>
(0,5)<br>
(4,1)<br>
(0,1)<br>
(1,0)<br>
<br>


