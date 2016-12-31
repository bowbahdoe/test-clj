(ns site.game-of-thrones
  (:require [ajax.core :refer [GET POST]]
            [re-frame.core :refer [reg-event-db dispatch]]))



(reg-event-db
  :get-characters
  (fn [db _]
    (GET "http://anapioficeandfire.com/api/characters/2"
        {:handler  #(dispatch [:add-character %])
         :error-handler #(prn %)
         :response-format :json
         :keywords? true})
    db))

(reg-event-db
  :add-character
  (fn [db [_ deets]]
    (prn  deets)
    db))
