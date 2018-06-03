package textTemplate

const html = `
{{template "header" .Title}}
{{if  eq  .Message   "the message is here"}}
		<h1>Oliver  {{ .Message}}</h1>
{{else }}
   <h1>No data passed as the message is here</h1>
{{end}}
<h1> The List Items </h1>
<ul>
	{{range .Fruit}}
	 		<li>{{.}}</li>
	{{else}}
</ul>
"No data"
{{end}}
{{template "footer"}}
`
const header = `
<!DOCTYPE html>
<html>
<head>
<title>{{.}} </title>
</head>
<body>
`
const footer = `
</body>
</html>`

var data [3]string

func init() {
	data[0] = html
	data[1] = header
	data[2] = footer
}

func TextTemplate() [3]string {
	return data
}
