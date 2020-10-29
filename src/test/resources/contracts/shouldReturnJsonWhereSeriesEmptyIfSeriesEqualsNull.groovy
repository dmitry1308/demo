package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return JSon String"
    request {
        method POST()

        url("/passport")

        headers {
            contentType(applicationJson())
        }

        body(file("DataDmitry.json"))
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