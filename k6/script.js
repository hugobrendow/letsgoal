import http from 'k6/http';
import { check, sleep } from 'k6';

export let options = {
  vus: 150,
  duration: '10s',
};

export default function () {
	
	const url = (__ENV.PRIVATE === 'true')
		? `http://username:password@host.docker.internal:8081/patrocinadores`
		: 'http://host.docker.internal:8081/formacoes';
	const res = http.get(url);
	
	check(res, {
	    'status is 200': (r) => r.status === 200
	});
	
	//think time
	sleep(1);
}