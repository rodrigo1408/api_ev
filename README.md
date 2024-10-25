A basic example management battery and control power for an vehicle eletric system.
We will follow the RESTful approach, where the system will provide APIs to query the battery status and adjust the motor power based on (simulated)acceleration, 
temperature management, regenerative braking, fault diagnosis and driving mode.

endpoints example:

1. **Get battery status**: 
    
    ```
    GET /battery/status
    ```

2. **Charge the battery**:

    ```
    POST /battery/recharge?amount=10
    ```

3. **Discharge the battery**:

    ```
    POST /battery/discharge?amount=20
    ```

4. **Calculate engine power based on throttle position**:

    ```
    GET /motor/power?throttlePosition=70
    ```

5. *Get temperature status**:

    ```    
    GET /temperature/status
    ```
    
6. **Perform system diagnostic**:
    
    ```
    GET /diagnostics
    ```
    
7. **Apply regenerative braking**:
    
    ```
    POST /braking/regenerative?brakingForce=50
    ```
    
8. **Calculate speed based on power**:
    
    ```
    GET /motor/speed?power=60
    ```
    
9. **Adjust driving mode (Economic, Esporty)**:
    
    ```
    POST /driving/mode?mode=ECO   
    ```
