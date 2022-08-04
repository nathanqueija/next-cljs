(ns demo.core)

(defn patch-goog! []
  ;; patch away the already declared exception and checks
  ;; otherwise hot-reload may fail
  (set! js/goog.provide js/goog.constructNamespace_)
  ;; also override goog.require to just return the namespace
  ;; which is needed inside goog.module modules. otherwise
  ;; the return is ignored anyways.
  ;; this isn't strictly needed but ensures that loading
  ;; actually only does what we want and not more
  (set! js/goog.require js/goog.module.get))

(patch-goog!)
