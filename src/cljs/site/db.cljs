(ns site.db)

;; ----------------------------------------------------------------------------

;; A Tabbed-View-State is a
;; -- {:tab-opened N}

;; INTERPRETATION
;; -- :tab-opened represents the current tab of the
;; view that is selected. It is a N that is zero indexed
;; (i.e. the first tab is tab 0 and so on)

;; ----------------------------------------------------------------------------

;; A State is a
;; -- {:tabbed-view Tabbed-View-State}

;; ----------------------------------------------------------------------------

(def default-db
  {:tabbed-view {:tab-opened 0}})
