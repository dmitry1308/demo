package contracts

import org.springframework.cloud.contract.spec.Contract
Contract.make {
    description "should return even when number input is even"
    request{
        method GET()
        url("/validate/prime-number") {
            queryParameters {
                parameter("number", "data/DataDmitry.json")
            }
        }
    }
    response {
        body('''
          {
            "series":5006,
            "number": 1111
          }
          ''')
        status 200
    }
}