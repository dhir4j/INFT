bmiTell :: (RealFloat a) => a -> String
bmiTell bmi
  | bmi <= 18.5 = "You're under weight"
  | bmi <= 25.0 = "You're supposedly normal!"
  | bmi <= 30.0 = "Your're Fat!"
  | otherwise = "Something wrong!"        