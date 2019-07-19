## Requirements:

1. Handle large write volume: Billions write events per day.
2. Handle large read/query volume: Millions merchants want to get insight about their business. Read/Query patterns are time-series related metrics.
3. Provide metrics to customers with at most one hour delay.
4. Run with minimum downtime.
5. Have the ability to reprocess historical data in case of bugs in the processing logic.
	
## Solution:	
This system have three main functional aspects.

![image link](images/analytic_system_functional.svg)

**1. Collection:**  
 - A hit is unit of data in analytics. Every user interaction with website or app generates hit request.
 - It gathers all info and meta data associated with that hit and send it to collection server.
 - Collection servers receives all information and store that raw data. 

**2. Processing:**   
- After collecting raw data, processing system will perform aggregation of data based on session, website, time and so on.
- It will create format data according to needs of reports.
- Finally store this formatted data which will be used for reports.

**2. Reporting:** 
- Reporting system will just read data according to required filters.
- It will also take care of requested output format.

#### Technical flow
Above functional flow can be implemented as shown in diagram.
![image link](images/analytic_system_design.svg)