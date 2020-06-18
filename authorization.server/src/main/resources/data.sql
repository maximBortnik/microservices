--
-- Users: john/john@123 kelly/kelly@123
--
INSERT INTO users (username,password,enabled)
    VALUES ('john', '$2a$11$arWHGwiQh77i5igNnV2EteMY06yQ9bM5gvA03IzVx.osDB.ODxvQ6', 'john@gmail.com');
INSERT INTO users (username,password,enabled)
    VALUES ('kelly','$2a$11$o04gyL6pBetIanlSyZwJZ.C1CrIohHLBXvvVB0cybvmxuij0qK77a', 'kelly@gmail.com');

--
-- Client: appclient/appclient@123
--
INSERT INTO
  oauth_client_details (
    client_id,
    client_secret,
    resource_ids,
    scope,
    authorized_grant_types,
    access_token_validity,
    refresh_token_validity
  )
VALUES
  (
    'appclient',
    '$2a$11$cHbTw9QydLgvc0Ewf1.Ajuy99X4Wgn/o6.UDhTZ/OvFCJBz/jnJxm',
    'client-service',
    'read,write',
    'authorization_code,check_token,refresh_token,password',
    1000000,
    1000000
  );