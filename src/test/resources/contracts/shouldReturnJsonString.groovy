package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return JSon String"
    request {
        method GET()
        url("passport") {
            queryParameters {
                parameter("path", "data/DataDmitry.json")
            }
        }
    }
    response {
        body('''
          {
            "series":"1111",
            "number":"2222",
          }
          ''')
        status 200
    }
}