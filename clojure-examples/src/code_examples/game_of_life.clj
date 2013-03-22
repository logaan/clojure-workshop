(ns code-examples.game-of-life
  (:use midje.sweet))

(defn neighbours [[x y]]
  (for [dx [-1 0 1] dy (if (zero? dx) [-1 1] [-1 0 1])]
    [(+ dx x) (+ dy y)]))

(defn step [cells]
  (set (for [[loc n] (frequencies (mapcat neighbours cells))
             :when (or (= n 3) (and (= n 2) (cells loc)))]
         loc)))

(def step
#(set(for[[b n](frequencies(mapcat(fn[[x y]](for[c[-1 0 1]d(if(= 0 c)[-1 1][-1 0
1])][(+ c x)(+ d y)]))%)):when(or(= n 3)(and(= n 2)(% b)))]b))
)

(def blinker #{[1 0] [1 1] [1 2]})

(fact (take 5 (iterate step blinker))
  => '(#{[1 0] [1 1] [1 2]} 
       #{[2 1] [1 1] [0 1]} 
       #{[1 0] [1 1] [1 2]} 
       #{[2 1] [1 1] [0 1]} 
       #{[1 0] [1 1] [1 2]})) 

