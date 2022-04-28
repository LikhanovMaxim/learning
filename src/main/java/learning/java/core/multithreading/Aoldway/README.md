TODO

## Why the old way is bad???

- Creating a new thread causes some performance overhead.
- Too many threads can lead to reduced performance, as the CPU needs to switch between these threads.
- You cannot easily control the number of threads, therefore you may run into out of memory errors due to too many threads.

### dla

- The Future interface is limited as a model of asynchronously executed tasks. 
- Future allows a client to query a Callable task for its result. 
- It does not provide the option to register a callback method. A callback method would allow you to get a callback once a task is done. 
