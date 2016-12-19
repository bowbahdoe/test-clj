(ns site.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [site.core-test]))

(doo-tests 'site.core-test)
