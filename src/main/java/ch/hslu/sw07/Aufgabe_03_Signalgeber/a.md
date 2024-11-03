Beantworten Sie folgende Fragen:

    1)  Wie fair ist das im Input N21vorgestellte Semaphor?
Nicht sehr fair, es wird kein FIFO Prinzip implementiert. Ein schwaches Semaphor besitzt einen Pool und garantiert nicht die chronologisch richtige Abarbeitung der Warteschlange.

    2)  Was ist die Ursache für die entsprechende Fairness?
Ein starkes Semaphor wäre fairer, da der erste wartende Thread als erstes benachrichtigt würde.

    3)  Wie könnten Sie die bestehende Fairness verbessern? 
Ein starkes Semaphore mit einer Queue implementieren.