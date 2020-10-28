package contracts

import org.springframework.cloud.contract.spec.Contract
Contract.make {
    description "should return JSon String"
    request{
        method GET()
        url("/validate/passportEntity") {
            queryParameters {
                parameter("path", "data/DataDmitry.json")
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