#sum of list
sumlist([],0).
sumlist([H|T],N):- sumlist(T,N1),N is N1+H.

Query:
sumlist([1,2,3,5],N).

#size of list 

size([],0).
size([_|T],N):-size(T,N1),N is N1+1.

Query:
size([2,3,1,4,5],N).
