docker run
    --cap-add=IPC_LOCK
     -e 'VAULT_LOCAL_CONFIG=
     {"
        backend": {"file": {"path": "/vault/file"}}, "default_lease_ttl": "168h", "max_lease_ttl": "720h

        "}'}

        vault server

storage "consul" {
  address = "127.0.0.1:8500"
  path    = "vault"
}

listener "tcp" {
  address     = "127.0.0.1:8200"
  tls_disable = 1
