;; Namespace declaration
(ns code-examples.core
  (:use midje.sweet))

; NOTE: Don't go into details of numbers being unboxed and strings being real
; java strings. Instead make a comment at the end for people concerned about
; performance.

; NOTE: Don't mention metadata. It's confusing and not that used, not exciting.

;; SCALARS

nil

true
false

3.14

"Kittens are cute"

; NOTE: Pause to give people a moment to look at the syntax. Then explain what
; it is and how it works.

\H
\i

:hello

:foo/bar

'println 

'clojure.core/println 

;; COLLECTIONS

[1, 2, 3, 4] 

; Clojure may have some parens. But your language has way too many commas.

[1 2 3 4]

[1 2 :three "four"]

{:foo 1, :bar 2}

{:foo 1 :bar 2}

{
 "fizz"  true 
 :bugs   false
 [1 2 3] {:do "re"}
}

#{1 2 3}

'(1 2 3)

; Now we tend to work on all of these collections through a common abstraction.
; This is called the sequence abstraction. And it lets us:

(first [1 2 3])
; => 1

(first '(1 2 3))
; => 1

(first #{1 2 3})
; => 2

(first {:one 1 :two 2})
; => [:two 2]

; The sequence abstraction is a bit like iterators. It's built around just two
; functions: first and rest. The cool thing about that is that it lets us have
; infinite sequences. Range will create a sequence of all the numbers up to 10. 

(range 10)
; => (0 1 2 3 4 5 6 7 8 9)

; Please don't be confused by the syntax for a sequence. It's printed like a
; list because there is no literal syntax for sequences.

; But we can also call range without any limits and it'll return a lazy
; sequence of every number from zero upwards.  Of course that's an issue
; because if you try and run that code your repl will try and print an infinite
; number of numbers. So we have to just take a few of those.

(take 5 (range))
; => (0 1 2 3 4)

; FUNCTIONS 

; You may be used to code like println("Hello, World"). To write this in lisp
; we just take the paren and move it to the outside. That wasn't so hard. 

(println "Hello, World")

; You'll notice that the syntax for calling a function and the syntax for lists
; are the same. Except that lists have an apostrophy in the front. That's one
; of the important parts of Clojure and we'll be diving into it more after
; lunch.

(+ 40 2)

(+ 10 8 20 4)

; Here's how you define a function.
(fn [name]
  (println "Hello " name))

; And here's how to give something a name
(def host "Thoughtworks")

; So we can use these two very simple ideas together to create a named
; function. The profoundness of this might take a while to sink in. Many
; popular languages can't do this. You can't just create a function and name it
; without first declaring a class or something. And the function stays as a
; value, just like the string from the last slide.
;
; But of course this is verbose and we don't write our functions like this
; normally.
(def greet
  (fn [name]
    (println "Hello " name)))

; Instead we use the defn macro, which looks like this.
(defn greet [name]
  (println "Hello " name))

; But that name doesn't have to be our function's only name. Functions are just
; like any other piece of data in Clojure. We can pass them into other
; functions.

(map inc [1 5 9])
; => [2 6 10]

; Here you can see that map is taking in inc, which adds 1 to numbers, and runs
; it over each of our numbers.

; We can also return function's from our functions. This lets us create
; function factories.

(defn create-incrementor [increment-by]
  (fn [number]
    (+ number increment-by)))

(map (create-incrementor 7) [1 5 9])
; => [8 12 16]

; You can probably do the same thing in your language. The latest versions of
; Java and C++ have lambads. C# has had them for a while. Ruby, Javascript and
; Python have had them since the beginning. One nicety of Clojure's functions
; is that there's only one type of them. Most other languages make some
; distinction between lambdas and methods. 

; Now I'm going to take a brief tangent and give you a taste of macros. They
; are incredibly powerful and they are the reason lisps look the way they do.
; They are considered an advanced topic and so don't stress if this doesn't
; sink in.

; So we can think about our code as data. This will return a list with a symbol
; and a string. It will not print the words to the screen and it will not
; return nil (like prinln normally does).

'(println "Hello, World")

; We can look inside this list just like any other list. First will pull out
; the symbol 'println. Remember that we're dealing with the name, and not the
; function that it symbolises.

(def original-code
  '(println "Hello, World"))

(first original-code)

; Now we could take that name and put it in an other list.

(def function-name
  (first '(println "Hello, World")))

(list function-name "Goodbye, Cruel World" )

; And we end up with

'(println "Goodbye, Cruel World")

; So we've taken apart some code and transplanted it into a new position. We
; can now run that code with eval.

(def new-code
  (list function-name "Goodbye, Cruel World" ))

(eval new-code)

; A macro is just a function that runs at compile time. It gets the code from
; it's arguments quoted. Inside the macro you mess around with that code and
; return some new code. The compiler then uses that new code just as though it
; had been written in the file all along.
;
; So this code will take our hello world and transform it into a goodbye cruel
; world. I hope that gives you a taste of what you can do with macros and helps
; you understand why you might be happy living in a world of slightly weird
; looking code. If not, then don't stress, you'll probably never have to write
; a macro yourself.

(defmacro emoify [original-code]
  (let [function-name (first original-code)]
    (list function-name "Goodbye, Cruel World")))

(emoify (println "Hello, World"))

