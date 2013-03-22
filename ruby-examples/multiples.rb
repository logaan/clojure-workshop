# Multiples of 3 and 5
#
# If we list all the natural numbers below 10 that are multiples of 3 or 5, we
# get 3, 5, 6 and 9. The sum of these multiples is 23.
#
# Find the sum of all the multiples of 3 or 5 below 1000.
#
# ANSWER: 233168

counter = 1
sum = 0

while counter < 10
  if counter % 3 == 0 || counter % 5 == 0
    sum = sum + counter
  end
  
  counter = counter + 1
end

puts sum

###########################################

good_numbers = []

for number in 1...10
  if number % 3 == 0 || number % 5 == 0
    good_numbers << number
  end
end

puts good_numbers.reduce(&:+)

###########################################

total = (1...10).reduce(0) do |total, number|
  if number % 3 == 0 || number % 5 == 0
    total + number
  else
    total
  end
end

puts total

###########################################

puts (1...10).find_all{|n| n % 3 == 0 || n % 5 == 0 }.reduce(&:+)

