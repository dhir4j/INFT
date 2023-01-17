familytree(A,B):- male(A),female(B).
male(manohar).
male(kalidas).
male(satish).
male(dhiraj).
female(laxmi).
female(mahananda).
female(revati).
female(pratiksha).
parent_of(revati,dhiraj).
parent_of(revati,pratiksha).
parent_of(satish,dhiraj).
parent_of(satish,pratiksha).
parent_of(manohar,satish).
parent_of(laxmi,satish).
parent_of(kalidas,revati).
parent_of(mahananda,revati).
mother(A,B):- parent_of(A,B),female(A).
father(A,B):- parent_of(A,B),male(A).
haschild(A):- parent_of(A,_).
sister(A,B):- parent_of(C,A),parent_of(C,B),female(A),A\==B.
brother(A,B):-parent_of(C,A),parent_of(C,B),male(A),A\==B.
grandfather(A,B):-male(A),parent_of(A,C),parent_of(C,B).
grandfather(A,B):-female(A),parent_of(A,C),parent_of(C,B).