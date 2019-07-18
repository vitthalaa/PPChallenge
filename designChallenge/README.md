## Requirements:

1. Handle large write volume: Billions write events per day.
2. Handle large read/query volume: Millions merchants want to get insight about their business. Read/Query patterns are time-series related metrics.
3. Provide metrics to customers with at most one hour delay.
4. Run with minimum downtime.
5. Have the ability to reprocess historical data in case of bugs in the processing logic.
	
## Solution:	
This system have three main functional aspects.

![image link](images/analytic_system_functional.svg)

<!-- TODO: Add description -->


#### Technical stack
![image link](images/analytic_system_design.svg)