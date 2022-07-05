#Assumptions

1. Trade event id is a unique for whole system if we consider buy and sell orders.
2. For every cancel event there is a buy or sell event. (Cancel event without buy or sell event not implemented. if it's 
   a requirement need to implement it.)
3. Total for a position is positive if it has more buy trade events and negative if it has more sell trade events.
