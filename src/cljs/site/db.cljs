(ns site.db)



;; ----------------------------------------------------------------------------
;; A Page is a Symbol
;; -- 'home
;; -- 'jobs

;; INTERPRETATION
;; -- represents the current page that the user is navigated to

;; ----------------------------------------------------------------------------

;; A Job is a
;; {:_id String
;;  :name String,
;;  :status String,
;;  :project_name String,
;;  :email_address String,
;;  :phone_number String}

;; INTERPRETATION: Represents a submitted job

;; A JobCategory is one of
;; -- 'ALL
;; -- 'PRINTING
;; -- 'COMPLETED
;; -- 'PROBLEM
;; -- 'CLOSED


;; ----------------------------------------------------------------------------
;; A State is a
;; -- {:current-page Page
;;     :navbar {:expanded? Boolean}
;;     :jobs-page {:active-jobs |List Job|
;;                 :selected-category JobCategory}}

;; ----------------------------------------------------------------------------

(def default-db
  {:current-page 'home
   :navbar {:expanded? false}
   :jobs-page {:active-jobs '()
               :selected-category 'ALL}})
