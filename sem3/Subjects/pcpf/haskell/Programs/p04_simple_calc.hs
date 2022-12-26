main=do
  putStrLn("Please Enter the First Number: ")
  firstStr<-getLine
  putStrLn("Please enter the second number: ")
  secondStr<-getLine
  let firstNumber = read firstStr::Double
  let secondNumber = read secondStr::Double
  let total = firstNumber+secondNumber
  putStrLn("the sum of two numbers is :  "++ show total)
  let difference = firstNumber-secondNumber
  putStrLn("The Difference of Two numbers is :  "++show total)
  let difference = firstNumber-secondNumber
  putStrLn("The difference of two numbers is :  "++show difference)
  let multiplication = firstNumber*secondNumber
  putStrLn("The Multiplication of two numbers is :  "++show multiplication)
  let division = firstNumber/secondNumber
  putStrLn("The Divison of two numbers is :  "++show division)