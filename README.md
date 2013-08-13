trucadas
========
Is a distributed dialplan executor and ACD for FreeSWITCH.

Features:
---------
 * Layered architecture: separate processes handle the different subsystems: from event polling, event correlation, queuing of events, execution of call flows, call queueing and routing (call_center).
 * It is distributed: multiple poller processes can poll events from a single FreeSWITCH instance (or multiple clustered instances), without producing duplicated events on the event bus.
 * Active-Active cluster: each subsystem can be executed on multiple hosts simultaneously, and they all synchronize and share data on a common Data Grid (Hazelcast)

Dependencies/Frameworks:
------------------------
 * Spring Framework
 * ActiveMQ
 * Esper Complex Event Proccessing 
 * Hazelcast
