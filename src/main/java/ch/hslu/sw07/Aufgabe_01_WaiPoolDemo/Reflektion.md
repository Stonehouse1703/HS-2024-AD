Reflektieren Sie die Aufgabe (hilft auch bei einer eventuellen Präsentation) und beantworten Sie sich
die folgenden Fragen:

    1)  Was ist bei der Benachrichtigung mit Hilfe der notify/notifyAll Methoden zu beachten?
Sie müssen in einem synchronized-Block aufgerufen werden müssen.

    2)  Warum wird für die Benachrichtigung notifyAll empfohlen, statt notify?
da es alle wartenden Threads aufweckt -> Deadlocks verhindert / sicherstellt, dass alle Threads die Möglichkeiten haben, ihre Bedingungen erneut zu prüfen    

    3)  Was ist zu berücksichtigen, wenn man für die Benachrichtigung notifyAll verwendet?
Braucht mehr Ressourcen, weil alle Threads geweckt werden.
