(ns coreasync-project.core
  (require [clojure.core.async :as async])
  (:gen-class))

;; customer could be a map {:ticket N, :fib_input F}

(defn customers
  [num-customers]
  (let [customer-chan (async/chan)]
    ; put all the customers in the channel
    (async/go
      (doseq [n (range num-customers)]
        (async/>! customer-chan n)))
    ; return the channel
    customer-chan))

;;(def cs (customers 10))
;;(async/<!! cs)

(defn workers
  [num-workers]
  (let [worker-chan(async/chan)]
    (async/go
      (doseq [n (range num-workers)]
        (async/>! worker-chan n)))

    worker-chan))

(defn result
  println (fibn))

(pipeline
  4
  [:customers, :workers, :result]

  (defn f [{:customers, :workers}]
    fibn = fin(n)
    {:customers, :workers, :result(fibn)})

    [:customers, :workers])



(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
