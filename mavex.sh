#!/bin/sh

# Maven Express for Linux
VERSION="0.5"

# nome projeto
PROJECT="ca"

# inicio da execucao
START=`date`
START_S=$(date +%s)

ROOT_DIR=`pwd`

# arquivo de log
MAVEX_LOG="${ROOT_DIR}/mavexlog.txt"

LIGEIRO_DIR="${ROOT_DIR}/../Ligeiro"

Main() {
	echo ""
	echo "Maven Express for Linux ${VERSION} [${PROJECT}]"
	echo ""
	echo "Bom dia ${USER}!"
	echo "Para consultar o resultado do maven verifique o arquivo ${MAVEX_LOG}."
	echo "Para cancelar o script use \"Ctrl+C\"."
	echo "---------------------------------------------------------------------"

	if [ $# -eq 0 ]; then
		Help
		exit 1
	fi

	case $1 in
		"-c")
			shift ;
			CheckModuleCompileList $* ;
			DoTask compile $* ;;
		"-d")
			shift ;
			CheckModuleCompileList $* ;
			DoTask deploy $* ;;
		"-m")
			shift ;
			CheckModuleModelList $* ;
			CodeGenerate $* ;;
		"-t")
			shift ;
			CheckModuleModelList $* ;
			All $* ;;
		"-u")
			shift ;
			CheckModuleCompileList $* ;
			DoTask undeploy $* ;;
		"-a" | "--all")
			shift ;
			All "core" "principal" ;;
		"--clean")
			shift ;
			echo "" ;
			echo "Limpando projeto..." ;
			maven clean >> "${MAVEX_LOG}" ;;
		*)
			Help ;
			exit 1 ;;
	esac
}

Help() {
	target=$1

	if [ "$target" != "" ];then
		echo ""
		echo "Objetivo inexistente: ${target}"
		echo ""
	fi

	echo "Uso: ${0} [opcao] [lista de objetivos]"
	echo ""
	echo "[opcao]"
	echo "\t -a [--all] \t Gera e compila o codigo de todos os modulos."
	echo "\t -c \t\t Compila o codigo e realiza deploy."
	echo "\t -d \t\t Realiza o deploy."
	echo "\t -m \t\t Gera o codigo."
	echo "\t -t \t\t Gera e compila o codigo."
	echo "\t -u \t\t Realiza o undeploy."
	echo ""
	echo "[lista de objetivos para -m -t]"
	echo "\t core (inclui subdiretorios e common)"
	echo "\t operador"
	echo "\t sistema"
	echo "\t geral"
	echo "\t principal (inclui layout)"
	echo ""
	echo "[lista de objetivos para -c -d -u]"
	echo "\t common"
	echo "\t core (common + core)"
	echo "\t core-cd"
	echo "\t core-only"
	echo "\t core-operador"
	echo "\t core-sistema"
	echo "\t layout"
	echo "\t operador"
	echo "\t sistema"
	echo "\t geral"
	echo "\t principal (inclui layout)"
	echo ""
}

CodeGenerate() {
	while [ $# -gt 0 ]; do
		echo ""
		echo "Gerando modelo: ${1}"
		echo "Aguarde..."

		maven mda -Dprojeto=${PROJECT}-${1} >> "${MAVEX_LOG}"

		CheckError ${1} ${1} $?

#		mv -vf statistics/statistics_entities.xml ${LIGEIRO_DIR}/data/statistics/jabot/ControleAcesso/statistics_entities_${1}.xml
#		mv -vf statistics/statistics_services.xml ${LIGEIRO_DIR}/data/statistics/jabot/ControleAcesso/statistics_services_${1}.xml
#		mv -vf statistics/statistics_usecases.xml ${LIGEIRO_DIR}/data/statistics/jabot/ControleAcesso/statistics_usecases_${1}.xml

		shift
	done
}

DoTask() {

	task=$1
	shift

	case $task in
		"compile")
			task=0 ;;
		"deploy")
			task=1 ;;
		"undeploy")
			task=2 ;;
		*) ;;
	esac

	while [ $# -gt 0 ]; do
		echo ""
		if [ $task -eq 0 ]; then
			echo "Compilando codigo: $1"
		elif [ $task -eq 1 ]; then
			echo "Realizando deploy: $1"
		elif [ $task -eq 2 ]; then
			echo "Realizando undeploy: $1"
		fi
		echo "Aguarde..."

		case $1 in
			"bpm")
				;;
			"common")
				CompileCoreTarget $task common
				;;
			"core")
				CompileCoreTarget $task common core
				;;
			"core-cd")
				CompileCoreTarget $task core-cd
				;;
			"core-only")
				CompileCoreTarget $task core
				;;
			"layout")
				CompileWebTarget $1 $task layout
				;;
			"principal")
				CompileWebTarget $1 $task layout
				CompileWebTarget $1 $task principal
				;;
			*) ;;
		esac

		shift
	done
}

CompileCoreTarget() {

	task=$1
	shift

	while [ $# -gt 0 ]; do
		case $1 in
			"common")
				echo ""
				echo ""
				cd "${ROOT_DIR}/common"
				if [ $task -eq 0 ]; then
					maven jar:install deploy >> "${MAVEX_LOG}"
				elif [ $task -eq 1 ]; then
					maven deploy >> "${MAVEX_LOG}"
				elif [ $task -eq 2 ]; then
					maven undeploy >> "${MAVEX_LOG}"
				fi
				CheckError ${1} "./common" $?
				;;
			"core")
				echo ""
				echo ""
				cd "${ROOT_DIR}/core"
				if [ $task -eq 0 ]; then
					maven install deploy >> "${MAVEX_LOG}"
				elif [ $task -eq 1 ]; then
					maven deploy >> "${MAVEX_LOG}"
				elif [ $task -eq 2 ]; then
					maven undeploy >> "${MAVEX_LOG}"
				fi
				CheckError ${1} "./core" $?
				;;
			"core-cd")
				echo ""
				echo ""
				cd "${ROOT_DIR}/core/cd"
				if [ $task -eq 0 ]; then
					maven jar:install deploy >> "${MAVEX_LOG}"
				elif [ $task -eq 1 ]; then
					maven deploy >> "${MAVEX_LOG}"
				elif [ $task -eq 2 ]; then
					maven undeploy >> "${MAVEX_LOG}"
				fi
				CheckError ${1} "./core/cd" $?
				;;
			*) ;;
		esac

		shift
	done
}

CompileCoreEjbTarget() {
	target=$1
	task=$2
	module=$3

	echo ""
	echo ""
	cd "${ROOT_DIR}/core/cs/${module}"
	if [ $task -eq 0 ]; then
		maven ejb:install deploy >> "${MAVEX_LOG}"
	elif [ $task -eq 1 ]; then
		maven deploy >> "${MAVEX_LOG}"
	elif [ $task -eq 2 ]; then
		maven undeploy >> "${MAVEX_LOG}"
	fi
	echo "------ Resultado do maven para ${target} (./core/cs/${module}): $?"
	CheckError ${target} "./core/cs/${module}" $?
}

CompileWebTarget() {
	target=$1
	task=$2
	module=$3

	echo ""
	echo ""
	cd "${ROOT_DIR}/web/${module}"
	if [ $task -eq 0 ]; then
		maven install deploy >> "${MAVEX_LOG}"
	elif [ $task -eq 1 ]; then
		maven deploy >> "${MAVEX_LOG}"
	elif [ $task -eq 2 ]; then
		maven undeploy >> "${MAVEX_LOG}"
	fi
	CheckError ${target} "./web/${module}" $?
}

All() {
	CodeGenerate $*
	DoTask compile $*
}

CheckModuleModelList() {
	for module in $*; do
		case $module in
			"bpm") ;;
			"core") ;;
			"principal") ;;
			*)
				Help $module;
				exit 1;;
		esac
	done
}

CheckModuleCompileList() {
	for module in $*; do
		case $module in
			"bpm") ;;
			"common") ;;
			"core") ;;
			"core-cd") ;;
			"core-only") ;;
			"principal") ;;
			"layout") ;;
			*)
				Help $module;
				exit 1;;
		esac
	done
}

CheckError() {
	target=$1
	current=$2
	status=$3

	if [ $status -eq 0 ]; then
		echo "------ Resultado do maven para ${target} (${current}): SUCESSO"
	else
		echo ""
		echo "------ Resultado do maven para ${target} (${current}): ERRO"
		echo ""
		DisplayTime
		exit 1
	fi
}

DisplayTime() {
	# termino da execucao
	END=`date`
	END_S=$(date +%s)
	# tempo de execucao
	DIFF=$(( $END_S - $START_S ))

	min=`expr $DIFF / 60`
	sec=`expr $DIFF - $min \* 60`

	if [ $min -lt 10 ]; then
		min="0${min}"
	fi
	if [ $sec -lt 10 ]; then
		sec="0${sec}"
	fi

	echo ""
	echo "Tempo de execucao: ${min}:${sec}"
	echo "Comecou em: $START"
	echo "Terminou em: $END"
	echo ""
}

# gerando um novo arquivo de log
cat /dev/null > "${MAVEX_LOG}"

cd "${ROOT_DIR}"

Main $*

DisplayTime

exit 0

