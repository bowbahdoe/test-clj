(ns site.db)



;; ----------------------------------------------------------------------------
;; A Page is a Symbol
;; -- 'home
;; -- 'jobs

;; INTERPRETATION
;; -- represents the current page that the user is navigated to
;; ----------------------------------------------------------------------------

;; A State is a
;; -- {:current-page Page
;;     :navbar {:expanded? Boolean}}

;; ----------------------------------------------------------------------------

(def default-db
  {:current-page 'home
   :navbar {:expanded? false}})
