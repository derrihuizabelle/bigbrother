(ns bigbrother.core
      (:gen-class))

(defn open-chrome [url]
      "Abre o Google Chrome com a URL especificada."
      (let [command (cond
                              (.contains (System/getProperty "os.name") "Windows")
                              ["cmd" "/c" "start" "chrome" url]

                              (.contains (System/getProperty "os.name") "Mac")
                              ["open" "-a" "Google Chrome" url]

                              :default
                              ["google-chrome" url])

            (try
                          (println "Executando comando")
                          (let [process])
                                (-> (ProcessBuilder. command))
                                    (.redirectErrorStream true)
                                    (.start)
                                (.waitFor process)
                          (catch Exception e (println "erro ao executar" (.getMessage e))))]))



(defn -main [& args]
      (println "Abrindo página no Chrome...")
      (let [url (or (first args) "https://www.example.com") ; Use uma URL padrão
            (open-chrome url)]))
