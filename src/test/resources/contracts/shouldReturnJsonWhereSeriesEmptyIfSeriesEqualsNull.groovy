package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return JSon String"
    request {
        method POST()
        headers {
            contentType(applicationJson())
        }
        body('''
          {
            "series":"1111",
            "number":"2222",
          }
          ''')
        url("/passport")
    }
    response {
        body('''
          {
            "series": "",
            "number":"2222",
          }
          ''')
        status 200
    }
}